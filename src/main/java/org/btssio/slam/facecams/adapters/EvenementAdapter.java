package org.btssio.slam.facecams.adapters;


import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.btssio.slam.facecams.objects.Evenement;
import org.btssio.slam.facecams.R;


public class EvenementAdapter extends ArrayAdapter<Evenement> {

	private Activity activity;
	private List<Evenement> items;
	private Evenement objBean;
	private int row;

	public EvenementAdapter(Activity act, int resource, List<Evenement> arrayList) {
		super(act, resource, arrayList);
		this.activity = act;
		this.row = resource;
		this.items = arrayList;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		View view = convertView;
		ViewHolder holder;
		
		if (view == null) {
			LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			view = inflater.inflate(row, null);

			holder = new ViewHolder();
			view.setTag(holder);
		} else {
			holder = (ViewHolder) view.getTag();
		}

		if ((items == null) || ((position + 1) > items.size()))
			return view;

		objBean = items.get(position);

		holder.nom = (TextView) view.findViewById(R.id.nom);
        //holder.date = (TextView) view.findViewById(R.id.date);
        holder.date = (TextView) view.findViewById(R.id.date);
		holder.list = (TextView) view.findViewById(R.id.list);
		holder.nombre = (TextView) view.findViewById(R.id.nombre);
		holder.type = (TextView) view.findViewById(R.id.type);


		if (holder.nom != null && null != objBean.getNom()
				&& objBean.getNom().trim().length() > 0) {
			holder.nom.setText(Html.fromHtml(objBean.getNom()));
		}

        if (holder.date != null && null != objBean.getDate()
                && objBean.getDate().trim().length() > 0) {
            holder.nom.setText(Html.fromHtml(objBean.getDate()));
        }
		if (holder.list != null && null != objBean.getList()
				&& objBean.getList().trim().length() > 0) {
			holder.list.setText(Html.fromHtml(objBean.getList()));
		}
		if (holder.nombre != null && null != objBean.getNombre()
				&& objBean.getNombre().trim().length() > 0) {
			holder.nombre.setText(Html.fromHtml(objBean.getNombre()));
		}
		if (holder.type != null && null != objBean.getType()
				&& objBean.getType().trim().length() > 0) {
			holder.type.setText(Html.fromHtml(objBean.getType()));
		}
		return view;
	}

	public class ViewHolder {
		public TextView nom, list, nombre, type , date;
	}
}