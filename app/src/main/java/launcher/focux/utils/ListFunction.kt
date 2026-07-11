package launcher.focux.utils

import launcher.focux.AppModel


fun List<AppModel>.sort() : MutableMap<String, MutableList<AppModel>> {
    val sorted : MutableMap<String, MutableList<AppModel>> = mutableMapOf()

    this.forEach {
        if(sorted.containsKey(it.name[0].toString())) {
            sorted[it.name[0].toString()]!!.add(it)
        } else {
            sorted.putIfAbsent(it.name[0].toString(), mutableListOf<AppModel>(it))
        }
    }

    return sorted.toSortedMap()
}