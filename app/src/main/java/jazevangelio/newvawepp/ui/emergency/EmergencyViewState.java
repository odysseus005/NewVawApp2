package jazevangelio.newvawepp.ui.emergency;

import android.os.Bundle;
import android.support.annotation.NonNull;

import com.hannesdorfmann.mosby.mvp.viewstate.RestorableViewState;

class EmergencyViewState implements RestorableViewState<EmergencyListView> {
    @Override
    public void saveInstanceState(@NonNull Bundle out) {

    }

    @Override
    public RestorableViewState<EmergencyListView> restoreInstanceState(Bundle in) {
        return this;
    }

    @Override
    public void apply(EmergencyListView view, boolean retained) {

    }
}
