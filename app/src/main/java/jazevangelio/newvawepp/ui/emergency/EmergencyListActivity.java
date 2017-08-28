package jazevangelio.newvawepp.ui.emergency;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.hannesdorfmann.mosby.mvp.viewstate.MvpViewStateActivity;
import com.hannesdorfmann.mosby.mvp.viewstate.ViewState;

import java.util.List;

import io.realm.Case;
import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmResults;
import jazevangelio.newvawepp.MainActivity;
import jazevangelio.newvawepp.R;
import jazevangelio.newvawepp.SOSSection;
import jazevangelio.newvawepp.databinding.ActivityEmergencyListBinding;
import jazevangelio.newvawepp.databinding.DialogEmergencyBinding;
import jazevangelio.newvawepp.model.data.Emergency;
import jazevangelio.newvawepp.model.data.User;
import jazevangelio.newvawepp.ui.login.LoginActivity;
import jazevangelio.newvawepp.ui.profile.ProfileActivity;
import jazevangelio.newvawepp.util.SmsUtil;


public class EmergencyListActivity
        extends MvpViewStateActivity<EmergencyListView, EmergencyListPresenter>
        implements SwipeRefreshLayout.OnRefreshListener, EmergencyListView{

    private ActivityEmergencyListBinding binding;
    private Realm realm;
    private User user;
    private EmergencyListAdapter adapterPromo;
    private RealmResults<Emergency> emergencyRealmResults;
    private Dialog dialog;
    private ProgressDialog progressDialog;

    @SuppressWarnings("ConstantConditions")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        realm = Realm.getDefaultInstance();
        user = realm.where(User.class).findFirst();
        binding = DataBindingUtil.setContentView(this, R.layout.activity_emergency_list);
        setSupportActionBar(binding.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Contact Person");

        presenter.onStart();
        // binding.swipeRefreshLayout.setColorSchemeColors(getResources().getIntArray(R.array.swipe_refresh_layout_color_scheme));
        binding.swipeRefreshLayout.setOnRefreshListener(this);
        binding.recyclerView.setItemAnimator(new DefaultItemAnimator());
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int topRowVerticalPosition = (recyclerView == null || recyclerView.getChildCount() == 0)
                        ? 0 : recyclerView.getChildAt(0).getTop();
                binding.swipeRefreshLayout.setEnabled(topRowVerticalPosition >= 0);
            }
        });
        adapterPromo = new EmergencyListAdapter(this, getMvpView());
        binding.recyclerView.setAdapter(adapterPromo);
        emergencyRealmResults = realm.where(Emergency.class).findAllAsync();
        emergencyRealmResults.addChangeListener(new RealmChangeListener<RealmResults<Emergency>>() {
            @Override
            public void onChange(RealmResults<Emergency> element) {
               List<Emergency> promoList = realm.copyFromRealm(emergencyRealmResults);
                adapterPromo.setEmergencyList(promoList);
                adapterPromo.notifyDataSetChanged();

            }
        });
        binding.swipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                binding.swipeRefreshLayout.setRefreshing(true);
                onRefresh();
            }
        });
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_promo_list, menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
               onBackPressed();
                return true;

            case R.id.action_add:
                add();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onDestroy() {
        presenter.onStop();
        emergencyRealmResults.removeChangeListeners();
        realm.close();
        super.onDestroy();
    }

    @NonNull
    @Override
    public EmergencyListPresenter createPresenter() {
        return new EmergencyListPresenter();
    }

    @NonNull
    @Override
    public ViewState<EmergencyListView> createViewState() {
        setRetainInstance(true);
        return new EmergencyViewState();
    }

    @Override
    public void onNewViewStateInstance() {

    }

    @Override
    public void startLoading() {
        if (progressDialog == null) {
            progressDialog = new ProgressDialog(this);
            progressDialog.setMessage("Updating...");
            progressDialog.setCancelable(false);
        }
        progressDialog.show();
    }

    @Override
    public void stopLoading() {
        if (progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }

    @Override
    public void stopRefresh() {
        binding.swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void showAlert(String message) {
        new AlertDialog.Builder(this)
                .setTitle(message)
                .setPositiveButton("Close", null)
                .show();
    }

    @Override
    public void OnButtonDelete(Emergency emergency) {


        presenter.deleteContact(""+user.getUserId(),""+emergency.getUserId());

    }

    @Override
    public void OnButtonEdit(Emergency emergency) {

        dialog = new Dialog(EmergencyListActivity.this);
        final DialogEmergencyBinding dialogBinding = DataBindingUtil.inflate(
                getLayoutInflater(),
                R.layout.dialog_emergency,
                null,
                false);
        dialogBinding.cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialogBinding.send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.updateContact(""+user.getUserId(),
                        dialogBinding.etName.getText().toString(),dialogBinding.etContact.getText().toString()/*,
                        dialogBinding.etConfirmPass.getText().toString()*/);
                dialog.dismiss();
            }
        });
        dialog.setContentView(dialogBinding.getRoot());
        dialog.setCancelable(false);
        dialog.show();

    }

    @Override
    public void onRefresh() {
        presenter.load(""+user.getUserId());
    }

    @Override
    public void onRefreshDelete() {
        presenter.load(""+user.getUserId());
    }

    public void add()
    {

        dialog = new Dialog(EmergencyListActivity.this);
        final DialogEmergencyBinding dialogBinding = DataBindingUtil.inflate(
                getLayoutInflater(),
                R.layout.dialog_emergency,
                null,
                false);
        dialogBinding.cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialogBinding.send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.addContact(""+user.getUserId(),
                        dialogBinding.etName.getText().toString(),dialogBinding.etContact.getText().toString()/*,
                        dialogBinding.etConfirmPass.getText().toString()*/);
                dialog.dismiss();
            }
        });
        dialog.setContentView(dialogBinding.getRoot());
        dialog.setCancelable(false);
        dialog.show();

    }

    @Override
    public void successAdd(String name, String contact)
    {
        onRefresh();

        try {
            SmsUtil.sendNotification(contact,user.getFirstname(),name);
        }catch (Exception e)
        {
            Log.d("Error",e+"");
            showAlert("Can't Access Location");
        }


    }

    @Override
    public void onBackPressed()
    {
        startActivity(new Intent(this, SOSSection.class));
        finish();

    }



}


