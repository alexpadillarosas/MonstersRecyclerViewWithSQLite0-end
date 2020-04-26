package com.blueradix.android.monstersrecyclerviewwithsqlite.recyclerview;


import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.blueradix.android.monstersrecyclerviewwithsqlite.Entities.Monster;
import com.blueradix.android.monstersrecyclerviewwithsqlite.R;
import com.squareup.picasso.Picasso;

/**
 * We create this view holder representing the recycler_item_view.xml
 * The idea of this class is to create a class that can manipulate the view
 */
public class MonsterViewHolder extends RecyclerView.ViewHolder {

    //bind the recycler_item_view.xml elements
    public final ImageView monsterImageView;
    public final TextView monsterName;
    public final TextView monsterDescription;

    public MonsterViewHolder(@NonNull View itemView) {
        super(itemView);

        monsterImageView = itemView.findViewById(R.id.monsterImageView);
        monsterName = itemView.findViewById(R.id.monsterName);
        monsterDescription = itemView.findViewById(R.id.monsterDescription);

    }
    public void updateMonster(Monster monster){
//        Difference between res and assets:
//        https://www.concretepage.com/questions/413
//        Put images in drawable folder not assets folder. Assets folder is used to keep other types of file like pdf, js, txt, etc, preferable zipped


//        This is the reason why is better to use xml instead of png files
//        https://medium.com/the-android-guy/stop-using-pngs-use-vector-drawable-why-8ca68bed5335

//        Understanding vector image format: vector drawable
//        https://medium.com/androiddevelopers/understanding-androids-vector-image-format-vectordrawable-ab09e41d5c68

//        Picasso.get().load("file:///android_asset/monsters/" + monster.imageFileName.substring(3) + ".png").into(monsterImageView);
        View rootView = monsterImageView.getRootView();
        int resID = rootView.getResources().getIdentifier(monster.imageFileName , "drawable" , rootView.getContext().getPackageName()) ;
//        Picasso.get().load(resID).into(monsterImageView);
//        Picasso.get().load("file:///android_asset/monsters/monster_22.png").into(monsterImageView);
//        Picasso.get().load(R.drawable.monster_2).error(resID).into(monsterImageView);
        monsterImageView.setImageResource(resID);
        this.monsterName.setText(monster.getName());
        this.monsterDescription.setText(monster.getDescription());
    }


}
