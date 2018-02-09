package in.techfantasy.thepapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by campusiq on 08/02/18.
 */

public class DeclareListAdapter extends ArrayAdapter<DeclarationModel> {
    List<DeclarationModel> DeclarationList=new ArrayList<>();
    Context ctx;
    private int lastPosition = -1;
    public DeclareListAdapter(@NonNull Context context, int resource, @NonNull List<DeclarationModel> objects) {
        super(context, resource, objects);
        this.ctx=context;
        this.DeclarationList=objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//        return super.getView(position, convertView, parent);
        DeclarationModel dm = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        viewHolder viewHolder; // view lookup cache stored in tag

        final View result;

        if (convertView == null) {

            viewHolder = new viewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.declarationlistitem, parent, false);
            viewHolder.tvUrName = (TextView) convertView.findViewById(R.id.txtUrName);
            viewHolder.tvPartName = (TextView) convertView.findViewById(R.id.txtPartName);
            viewHolder.tvStory = (TextView) convertView.findViewById(R.id.txtStory);
            viewHolder.tvDates = convertView.findViewById(R.id.txtDates);

            result=convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (viewHolder) convertView.getTag();
            result=convertView;
        }

        Animation animation = AnimationUtils.loadAnimation(ctx, (position > lastPosition) ? R.anim.up_from_bottom : R.anim.down_from_top);
        result.startAnimation(animation);
        lastPosition = position;

        viewHolder.tvUrName.setText(dm.getUrName());
        viewHolder.tvPartName.setText(dm.getPartName());
        viewHolder.tvDates.setText(dm.getStDate()+"-"+dm.getEnDate());
        viewHolder.tvStory.setText(dm.getStory());
        // Return the completed view to render on screen
        return convertView;
    }


    public static class viewHolder{
        TextView tvUrName;
        TextView tvPartName;
        TextView tvStory;
        TextView tvDates;
    }
}
