package id.ac.pnm.ti.utsmobilesatu

import id.ac.pnm.ti.utsmobilesatu.Club

fun main() {
    // Inisialisasi mutableList dan tambah data List
    val clubs = mutableListOf<Club>()
    clubs.add(Club("Liverpool",19,8,9,6,3))
    clubs.add(Club("Manchester United",20,12,6,3,1))
    clubs.add(Club("Chelsea",6,6,5,2,2))
    clubs.add(Club("Manchester City",8,8,8,0,0))
    clubs.add(Club("Arsenal",13,14,2,0,0))

    // Passing a named function ::id.ac.pnm.ti.utsmobilesatu.sortByNumberTrophyTotal
    val sortedClubs = filterAndSort(clubs, ::sortByNumberTrophyTotal)
    println("===================================================================================")
    println("Urutan klub berdasarkan jumlah total trofi: ")
    for (club in sortedClubs) {
        println(club.recap())
    }

    // Passing a named function ::id.ac.pnm.ti.utsmobilesatu.filterByEuropeanTrophy
    val filteredClubs = filterAndSort(clubs, ::filterByEuropeanTrophy)
    // Hasil sorting total trofi
    println("===================================================================================")
    println("Klub yang belum pernah memenangkan UCL dan UEL:")
    for (club in filteredClubs) {
        println(club.name)
    }

    val liverpool = clubs.filter { it.name == "Liverpool" }
    println("===================================================================================")
    for (club in liverpool){
        println(club.detail())
    }

}

// High order function filter and sort
fun filterAndSort(clubs: List<Club>, options: (List<Club>) -> List<Club>): List<Club> {
    return options(clubs)
}

// Fungsi sorting
fun sortByNumberTrophyTotal(clubs: List<Club>): List<Club> {
    val sortedClubs = clubs.sortedByDescending(Club::totalTrophy)
    return sortedClubs
}

// Fungsi filter
fun filterByEuropeanTrophy(clubs: List<Club>): List<Club> {
    val filteredClubs = clubs.filter {
        it.UEL == 0 && it.UCL == 0
    }
    return filteredClubs
}

fun Club.detail(): String{
    return "$name berhasil meraih $EPL trofi Liga Primer Inggris, $FA trofi FA, $EFL trofi EFL, $UCL trofi Liga Champions, dan $UEL trofi Liga Eropa UEFA"
}


