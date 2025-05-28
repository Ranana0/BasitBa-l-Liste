package newpackage;


class Eleman {
    int icerik;
    Eleman ileri;
    
    public Eleman(int icerik) {
        this.icerik = icerik;
        ileri = null;
    }
}

public class BListe {
    Eleman bas, son;
    
    public BListe() {
        bas = null;
        son = null;
    }
    
    public void basaekle(Eleman yeni) {
        if(son == null){
            bas = yeni;
            son = yeni;
        }
        else{
            yeni.ileri = bas;
            bas = yeni;
        }
    }
    
    public void sonaekle(Eleman yeni) {
        if(bas == null) {
            bas = yeni;
            son = yeni;
        }
        else {
            son.ileri = yeni;
            son = yeni;
        }
    }
    
    public Eleman bastansil() {
        Eleman tmp = bas;
        if(bas != null) {
            bas = bas.ileri;
        }
        else {
            son = null;
            return null;
        }
        return tmp;
    }
    
    public Eleman sondansil() {
        Eleman tmp = bas, once = null, silinen = son;
        while(tmp != son) {
            once = tmp;
            tmp = tmp.ileri;
        }
        if(once == null) {
            bas = null;
            son = null;
            return null;
        }
        else {
            once.ileri = null;
            son = once;
            return silinen;
        }
    }
    
    public Eleman listeara(int aranan) {
        Eleman tmp = bas;
        while(tmp != null) {
            if(tmp.icerik == aranan)
                return tmp;
            else
                tmp = tmp.ileri;
        }
        return null;
    }
    
    public int yerBul(int aranan) {
        Eleman sonuc = listeara(aranan);
        if(sonuc != null) {
            Eleman tmp = bas;
            int sayac = 0;
            while(tmp.icerik != aranan) {
                tmp = tmp.ileri;
                sayac++;
            }
            return sayac;   
        }
        else
            return -1;
    }
    
    public String listele() {
        String s = "";
        Eleman tmp = bas;
        while(tmp != null) {
            s = s + tmp.icerik + " --> ";
            tmp = tmp.ileri;
        }
        return s;
    }
    
    public String yazdir(Eleman gecici) {
        if(gecici == null)
            return "";
        return gecici.icerik + " --> " + yazdir(gecici.ileri);
    }
    
    public void siraliekle(Eleman yeni) {
        Eleman tmp;
        //liste boş ya da yeni eleman küçük ise
        if(bas == null || bas.icerik >= yeni.icerik) {
            yeni.ileri = bas;
            bas = yeni;
        }
        else {
            tmp = bas;
            while(tmp.ileri != null && tmp.ileri.icerik < yeni.icerik)
                tmp = tmp.ileri;
            yeni.ileri = tmp.ileri;
            tmp.ileri = yeni;
        }
    }
    
    public Eleman elemansil(int aranan) {
        Eleman sonuc = listeara(aranan);
        Eleman tmpb = bas, tmps = son;
        if(sonuc != null) {
            if(aranan == tmpb.icerik)
                return bastansil();
            else if(aranan == tmps.icerik)
                return sondansil();
            else {
                Eleman tmp = bas, once = null;
                while(tmp.icerik != aranan) {
                    once = tmp;
                    tmp = tmp.ileri;
                }
                once.ileri = tmp.ileri;
                return tmp;
            }
        }
        else {
            return null;
        }
    }
}