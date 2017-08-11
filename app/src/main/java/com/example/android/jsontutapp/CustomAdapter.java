package com.example.android.jsontutapp;

import android.content.ClipData;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import com.bumptech.glide.module.AppGlideModule;

import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;



public class CustomAdapter extends ArrayAdapter<Countries> {
    private List<Countries> Clist=new ArrayList<>();
    private ImageView imgIcon;
    private ProgressBar progressBar;
    int index;

    public CustomAdapter( Context context, int resource, List<Countries> objects) {
        super(context, resource, objects);
        this.Clist=objects;

    }



    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listview = convertView;
            ViewHolder holder=null;


        if (listview == null) {
            // listview.setTag(holder);
            holder=new ViewHolder();
            listview = LayoutInflater.from(getContext()).inflate(R.layout.row, parent, false);
            listview.setTag(holder);


        } else {
            holder = (ViewHolder) listview.getTag();

        }



        // TextView countryFlag;

      //  progressBar=(ProgressBar)listview.findViewById(R.id.progress);


       // String flagUrl ="https://www.countries-ofthe-world.com/flags-normal/flag-of-"+ Cname+".png";


    //    new GetIcon().execute(flagUrl);
        //


        holder.countryName = (TextView) listview.findViewById(R.id.countryname);
       imgIcon = (ImageView) listview.findViewById(R.id.imgIcon);

        holder.countryCapital = (TextView) listview.findViewById(R.id.countrycapital);
        holder.countryRegion = (TextView) listview.findViewById(R.id.region);
        holder.countrySubregion = (TextView) listview.findViewById(R.id.subregion);
        holder.countryArea = (TextView) listview.findViewById(R.id.area);
        holder.countryPopulation = (TextView) listview.findViewById(R.id.ppln);
        holder.countryTimeZone = (TextView) listview.findViewById(R.id.timezones);
        holder.countryCallingCode = (TextView) listview.findViewById(R.id.callingcode);
        holder.countryLanguages = (TextView) listview.findViewById(R.id.langspoke);
        holder.countryBorders = (TextView) listview.findViewById(R.id.shareborder);
        holder.countryCurrency = (TextView) listview.findViewById(R.id.currencies);
        holder.countryDemonym = (TextView) listview.findViewById(R.id.demomyn);
     //   holder.countryAlpha2 = (TextView) listview.findViewById(R.id.alpha2code);
        holder.countryAlpha3 = (TextView) listview.findViewById(R.id.alpha3code);
        holder.countryNativeName = (TextView) listview.findViewById(R.id.nativename);



            index=Clist.indexOf(Clist.get(position));
        String Cname=Clist.get(position).getName();
        progressBar =(ProgressBar)listview.findViewById(R.id.progress);
        holder.countryName.setText(Cname);
        holder.countryCapital.setText(Clist.get(position).getCapital());
        holder.countryRegion.setText(Clist.get(position).getRegion().trim());
        holder.countrySubregion.setText("Subregion: " + Clist.get(position).getSubregion());
        holder.countryArea.setText("Area: " + Clist.get(position).getArea());
        holder.countryPopulation.setText("Population: " + Clist.get(position).getPopulation());
        StringBuffer Bt = new StringBuffer();

        holder.countryTimeZone.setText("Time Zones: " + Clist.get(position).getTimezones().toString().replace("[","").replace("]",""));
        holder.countryCallingCode.setText("Calling Code: "+Clist.get(position).getCallingCodes().toString().replace("[","").replace("]",""));

        holder.countryLanguages.setText("Languages Most Spoken: ");
        StringBuffer Bl = new StringBuffer();
        for (Countries.Languages l : Clist.get(position).getLanguages()) {
            Bl.append(l);
        }
        holder.countryLanguages.append(Bl);//+Clist.get(position).getLanguages().toString());

        if(Clist.get(position).getBorders().size()==0) {
            holder.countryBorders.setText("Share Borders with None " );
        }else   holder.countryBorders.setText("Shares Borders with: "+Clist.get(position).getBorders().toString().replace("[","").replace("]",""));

        holder.countryCurrency.setText("Currency: ");
        StringBuffer Bc = new StringBuffer();
        for (Countries.Currency c : Clist.get(position).getCurrencies()) {
            Bc.append(c);
        }
        holder. countryCurrency.append(Bc);//Clist.get(position).getCurrencies().toString());
        holder.countryDemonym.setText("Demonym: " + Clist.get(position).getDemonym());
      //  holder.countryAlpha2.setText(Clist.get(position).getAlpha2Code());
        holder.countryAlpha3.setText("Alpha 3 Code: "+Clist.get(position).getAlpha3Code());
        holder.countryNativeName.setText("Natives Name: " + Clist.get(position).getNativeName());
       String flag = Clist.get(position).getFlag();


     //  Glide.with(listview).as(SVG.class).load("http://upload.wikimedia.org/wikipedia/commons/e/e8/Svg_example3.svg");
        // mages urls   https://upload.wikimedia.org/wikipedia/en/thumb/4/41/Flag_of_India.svg/150px-Flag_of_India.svg.png

     // String flagbycountry="https://www.countries-ofthe-world.com/flags-normal/flag-of-"+Cname+".png";

        progressBar.setVisibility(View.VISIBLE);


            GlideApp.with(listview)
                    .load(flag)
                    .placeholder(R.mipmap.ic_launcher)
                    .error(R.mipmap.ic_launcher_round)
                    .transition(withCrossFade())
                    .into(imgIcon);
        progressBar.setVisibility(View.GONE);


        return listview;
    }




    public CustomAdapter setFilter(String text) {
           text= text.toLowerCase();
        List<Countries> newList = new ArrayList<>();
         Clist.addAll(newList);
        for(Countries c:Clist){
            String name=c.getName().toLowerCase();
            if(name.contains(text)){
                newList.add(c);

            }

        }



        notifyDataSetChanged();
       return new CustomAdapter(getContext(),R.layout.row,newList);



    }
  /*
    @Nullable
    @Override
    public Countries getItem(int position) {

        return Clist.get(index);
    }

    @Override
    public int getPosition(@Nullable Countries item) {
        return Clist.indexOf(item);
    }

    @Override
    public long getItemId(int position) {
        return  index;
        //return Clist.indexOf(getItem(position));
    }
*/

/*

 class GetIcon extends AsyncTask<String,String,Bitmap> {
     @Override
     protected Bitmap doInBackground(String... params) {
         // public Bitmap getImage(String imageUrl){
         HttpURLConnection imageCon = null;
         try {
             URL url = new URL(params[0]);
             imageCon = (HttpURLConnection) url.openConnection();
             imageCon.connect();
             InputStream imageStream = imageCon.getInputStream();
             Bitmap bitmap= BitmapFactory.decodeStream(imageStream);


             return bitmap;


         } catch (IOException e) {
             e.printStackTrace();
         }
         finally {
             if (imageCon != null) {
                 imageCon.disconnect();
             }
         }

         return null;
     }


     @Override
     protected void onPreExecute() {
         super.onPreExecute();

         progressBar.setVisibility(View.VISIBLE);


     }

     @Override
     protected void onPostExecute(Bitmap bitmap) {
         super.onPostExecute(bitmap);
         progressBar.setVisibility(View.GONE);
         imgIcon.setLayerType(View.LAYER_TYPE_SOFTWARE,null);
        imgIcon.setImageBitmap(bitmap);




}
     }
 }*/

 public class ViewHolder{

        TextView countryName;
        TextView countryCapital;
        TextView countryRegion;
        TextView countrySubregion;
        TextView countryArea;
        TextView countryPopulation;
        TextView countryTimeZone;
        TextView countryCallingCode;
        TextView countryLanguages;
        TextView countryBorders;
        TextView countryCurrency;
        TextView countryDemonym;
        TextView countryAlpha2;
        TextView countryAlpha3;
        TextView countryNativeName;




    }





}
