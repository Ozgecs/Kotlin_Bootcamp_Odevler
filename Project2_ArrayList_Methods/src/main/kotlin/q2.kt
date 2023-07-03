import java.util.*

fun main(){

    val girdi = Scanner(System.`in`)
    val names = arrayListOf("Sinem","Ali","Hümeyra","Cem","Gizem")

    /*
    * */
    // Harflere göre listeyi sıralama
    names.sort()
    println(names)

    // Kullanıcıdan isim iste ve bu ismi içinde arat.
    print("Bir adet isim giriniz: ")
    val isim = girdi.next()

    // İsim kontrolü ve istenen özellikler
    if (isim!= null && names.contains(isim)){
           println("Girdiğiniz isim listede bulunuyor")
           val buyuk = isim.uppercase()
           val ters = isim.reversed()
           val buyukters = buyuk.reversed()
           println("""
              
               İsimin harfleri büyük hali : $buyuk
               İsimin tersten yazılışı : $ters
               Büyük ve ters : $buyukters
               
           """.trimIndent())
    }else{
        println("Böyle bir isim bulunamadı ya da boş değer girişi")
    }

}