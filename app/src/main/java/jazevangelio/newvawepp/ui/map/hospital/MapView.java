package jazevangelio.newvawepp.ui.map.hospital;

import com.hannesdorfmann.mosby.mvp.MvpView;

import java.util.List;

import jazevangelio.newvawepp.model.data.NearCompany;


public interface MapView extends MvpView {
    void showNearest();

    void setNearestCompany(List<NearCompany> companyList);

   // void OnItemClicked(NearCompany companyList);

    void startLoading();

    void stopLoading();

    void showAlert(String s);

    void updateMap();
}
