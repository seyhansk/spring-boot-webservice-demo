package yaz.l.mgelistirme.springbootwebservicedemo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ogrenci")
public class OgrenciWebServisi {

    public record Ogrenci(String numara, String name) {}

    private static List<Ogrenci> OGRENCILER = new ArrayList<>();

    static {
        OGRENCILER.add(new Ogrenci("1", "Ayşe"));
        OGRENCILER.add(new Ogrenci("2", "Fatma"));
    }

    @GetMapping("/")
    public List<Ogrenci> listele() {
        return OGRENCILER;
    }

    @PostMapping("/")
    public void ekle(Ogrenci yeniOgrenci) {
        OGRENCILER.add(yeniOgrenci);
    }

    @DeleteMapping("/")
    public boolean sil(@RequestParam String numara) {
        for (Ogrenci ogrenci : OGRENCILER) {
            if (ogrenci.numara.equals(numara)) {
                OGRENCILER.remove(ogrenci);
                return true;
            }
        }
        //öğrenci bulunamadı
        return false;
    }
}
