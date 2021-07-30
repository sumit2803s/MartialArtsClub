package android.example.martialartsclub;

import android.content.Context;
import android.example.martialartsclub.Model.MartialArt;

import androidx.appcompat.widget.AppCompatButton;

public class MartialArtButton extends AppCompatButton {

    private MartialArt martialArtObject;

    public MartialArtButton(Context context, MartialArt martialArt) {

        super(context);
        martialArtObject=martialArt;
    }

    public String getMartialArtColor(){

        return martialArtObject.getMartialArtColor();
    }

    public double getMartialArtPrice() {

        return  martialArtObject.getMartialArtPrice();
    }

}
