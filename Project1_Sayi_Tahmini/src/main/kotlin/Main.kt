import kotlin.random.Random
fun main() {
    var tahminHakki = 3
    val rastgele = Random.nextInt(0, 101)

    println("****TAHMİN OYUNU BAŞLASIN****")
    print("Bir sayı tuttum. Tuttuğum sayıyı tahmin et: ")
    while (tahminHakki > 0){
        val kullaniciTahmini = readlnOrNull()?.toIntOrNull()

        if (kullaniciTahmini!=null){
            if (kullaniciTahmini == rastgele){
                println("Tebrikler, doğru tahmin ettin!!!")
                break

            }else if(kullaniciTahmini > rastgele){
                tahminHakki-=1
                println("Tuttuğum sayıdan daha büyük bir sayı tahmin ettin.")
                println("Kalan tahmin hakkın: $tahminHakki")

            }else{
                tahminHakki-=1
                println("Tuttuğum sayıdan daha küçük bir sayı tahmin ettin. ")
                println("Kalan tahmin hakkın: $tahminHakki")
            }

            if(tahminHakki>0){
                print("Yeni bir tahmin yap: ")
            }
            else{
                println("Tuttuğum sayı $rastgele idi.")
                println("Tahmin hakkın kalmadı. Oynadığın için teşekkürler...")
            }
        }else{
            tahminHakki-=1
            if (tahminHakki>0){
                println("Kalan tahmin hakkın $tahminHakki")
                print("Geçerli bir sayı gir: ")
            }else{
                println("Tuttuğum sayı $rastgele idi.")
                println("Tahmin hakkın kalmadı. Oynadığın için teşekkürler...")
            }
        }
    }
}