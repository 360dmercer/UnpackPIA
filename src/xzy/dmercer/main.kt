package xzy.dmercer

import java.io.File

fun main(vararg arg: String){
    val filename = arg[0]
    val destination = arg[1]

    val pia = File(filename).readText()
    val piaFiles = pia.split("@FILE@")

    for (i in 1 until piaFiles.size){
        createFile(piaFiles[i], destination)
    }
}

fun createFile(source: String, desination: String){
    val filenameEndIndex = source.indexOf('\u0000', 5)
    val filename = source.substring(5,filenameEndIndex)
    println(filename)

    val file = File(desination,filename)
    if (file.exists()){

    }
    else{
        file.createNewFile()
    }

    val fileContent = source.substring(filenameEndIndex+1)
    file.writeText(fileContent)
}