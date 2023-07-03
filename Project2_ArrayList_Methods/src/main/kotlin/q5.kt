data class Workers(val name: String, var salary: Double)

fun main(){

    val workers = arrayListOf(
        Workers("Ahmet Yılmaz", 15000.0),
        Workers("Ayşe Kaya", 32000.0),
        Workers("Mehmet Demir", 29000.0),
        Workers("Fatma Şahin", 18500.0)
    )

    // Zammı hesapla ve üzerine ekle

    for (isci in workers){
        val zam = isci.salary*0.35
        isci.salary += zam
    }

    println("--------Zamlı Halleri-----------------")
    for(calisan in workers){
        println("${calisan.name} : ${calisan.salary}")
    }

    // Listeyi karıştır ve küçükten büyüğe sırala
    workers.shuffle()
    println("--------Sıralanmış Hali-----------------")
    val kucuktenBuyuge = workers.sortedBy{ it.salary}

    for (isci in kucuktenBuyuge){
        println("${isci.name} : ${isci.salary}")
    }


    // En Yüksek ve En Düşük Maaşlı Çalışanlar
    val azMaas = workers.minByOrNull { it.salary }
    val cokMaas = workers.maxByOrNull { it.salary }

    if (azMaas != null && cokMaas != null) {
        val minIndex = workers.indexOf(azMaas)
        val maxIndex = workers.indexOf(cokMaas)

        println("""
            
            En Çok Maaş Alan :  ${cokMaas.name}
            En Az Maaş Alan  :  ${azMaas.name}
            
        """.trimIndent())

    }

    // Maaş ortalamasının hesaplanması ve Yazdırılması

    var totalSalary = 0.0
    for (worker in workers) {
        totalSalary += worker.salary
    }

    val averageSalary = totalSalary / workers.size

    println("İşçilerin Maaş Ortalaması: $averageSalary")

}