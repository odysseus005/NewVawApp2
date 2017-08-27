package jazevangelio.newvawepp.ui.emergency;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;
import java.util.List;

import jazevangelio.newvawepp.R;
import jazevangelio.newvawepp.app.Constants;
import jazevangelio.newvawepp.app.Endpoints;
import jazevangelio.newvawepp.databinding.ItemEmergencyBinding;
import jazevangelio.newvawepp.model.data.Emergency;


public class EmergencyListAdapter extends RecyclerView.Adapter<EmergencyListAdapter.ViewHolder> {
    private final Context context;
    private final EmergencyListView view;
    private List<Emergency> emergencyList;

    public EmergencyListAdapter(Context context, EmergencyListView view) {
        this.context = context;
        this.view = view;
        emergencyList = new ArrayList<>();
    }

    public void setEmergencyList(List<Emergency> emergencyList) {
        this.emergencyList = emergencyList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemEmergencyBinding itemEmergencyBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.item_emergency,
                parent,
                false);
        return new ViewHolder(itemEmergencyBinding);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.itemEmergencyBinding.setEmergency(emergencyList.get(position));
        holder.itemEmergencyBinding.setView(view);
        //String imageURL = Endpoints.IMAGE_URL.replace(Endpoints.IMG_HOLDER, emergencyList.get(position).getImage());
        String imageURL = Constants.URL_IMAGE+emergencyList.get(position).getImage()+".jpg";
        Glide.with(context)
                .load(imageURL)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .error(R.drawable.profile_default)
                .into(holder.itemEmergencyBinding.imageProfile);
        Log.d("TAG",imageURL);
    }

    @Override
    public int getItemCount() {
        return emergencyList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final ItemEmergencyBinding itemEmergencyBinding;

        public ViewHolder(ItemEmergencyBinding itemEmergencyBinding) {
            super(itemEmergencyBinding.getRoot());
            this.itemEmergencyBinding = itemEmergencyBinding;
        }
    }
}
