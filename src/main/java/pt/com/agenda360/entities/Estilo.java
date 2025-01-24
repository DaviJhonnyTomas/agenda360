package pt.com.agenda360.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

public class Estilo {

    private String corPrimaria;
    private String corSecundaria;
    private String imgLogo;
    private String imgFundo;



    public String getCorPrimaria() {
        return corPrimaria;
    }

    public void setCorPrimaria(String corPrimaria) {
        this.corPrimaria = corPrimaria;
    }

    public String getCorSecundaria() {
        return corSecundaria;
    }

    public void setCorSecundaria(String corSecundaria) {
        this.corSecundaria = corSecundaria;
    }

    public String getImgLogo() {
        return imgLogo;
    }

    public void setImgLogo(String imgLogo) {
        this.imgLogo = imgLogo;
    }

    public String getImgFundo() {
        return imgFundo;
    }

    public void setImgFundo(String imgFundo) {
        this.imgFundo = imgFundo;
    }

}
