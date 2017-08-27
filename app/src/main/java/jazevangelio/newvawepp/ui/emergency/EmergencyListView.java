package jazevangelio.newvawepp.ui.emergency;

import com.hannesdorfmann.mosby.mvp.MvpView;

import java.util.List;

import jazevangelio.newvawepp.model.data.Emergency;

public interface EmergencyListView extends MvpView {

    void stopRefresh();

    void showAlert(String message);

   void OnButtonDelete(Emergency emergency);

    void OnButtonEdit(Emergency emergency);

    void startLoading();

    void stopLoading();

    void onRefreshDelete();

    void successAdd(String name, String cpntact);


}
