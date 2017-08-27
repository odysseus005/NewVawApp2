package jazevangelio.newvawepp.ui.map.hospital;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import jazevangelio.newvawepp.R;
import jazevangelio.newvawepp.databinding.ItemNearestBinding;
import jazevangelio.newvawepp.model.data.NearCompany;


public class MapListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private MapView mapView;
    private List<NearCompany> list;
    private static final int VIEW_TYPE_MORE = 1;
    private static final int VIEW_TYPE_DEFAULT = 0;
    private boolean loading;

    public MapListAdapter(MapView mapView) {
        this.mapView = mapView;
        list = new ArrayList<>();

    }


    @Override
    public int getItemViewType(int position) {
        return VIEW_TYPE_DEFAULT;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
         ItemNearestBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()), R.layout.item_nearest, parent, false);
        return new MapListAdapter.ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MapListAdapter.ViewHolder viewHolder = (MapListAdapter.ViewHolder) holder;
        viewHolder.binding.setCompany(list.get(position));
        viewHolder.binding.setView(mapView);

    }

    public void setList(List<NearCompany> list) {
        this.list.clear();
        this.list.addAll(list);
        notifyDataSetChanged();
    }

    public void clear() {
        list.clear();
        notifyDataSetChanged();
    }


    public void setLoading(boolean loading) {
        this.loading = loading;
        notifyDataSetChanged();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private ItemNearestBinding binding;

        public ViewHolder(ItemNearestBinding binding) {
            super(binding.getRoot());
            this.binding= binding;
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
