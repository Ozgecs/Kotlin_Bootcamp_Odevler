import java.util.*

fun main() {

    val girdi = Scanner(System.`in`)

    // 5 isim içeren bir arraylist
    val isimler = arrayListOf("Ayşe","Fatma","Ahmet","Özge","Beyza")


    // Kullanıcıdan virgülle üç isim girmesini iste
    print("Aralarında virgül koyarak 3 isim giriniz: ")
    val isimler2 = girdi.next()


    // isimleri al ve bir listeye dönüştür.
    val names = isimler2.split(",").map { it.trim() }
    names.toList()


    // Boş olup olmadığını kontrol et
    if (names.isEmpty()){
        println("Hatalı giriş!")
    }else{
        // Yeni halinin ekrana yazılması
        isimler.add(names.toString())
        print("Yeni İsim Listesi: $isimler")
    }


}