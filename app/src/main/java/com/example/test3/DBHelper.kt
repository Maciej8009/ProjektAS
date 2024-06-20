package com.example.test3

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context): SQLiteOpenHelper(context, "db", null, 1)

{
    override fun onCreate(db: SQLiteDatabase) {
        val query = ("CREATE TABLE Dane (id INTEGER PRIMARY KEY AUTOINCREMENT, city TEXT, name TEXT, description TEXT)")
        db.execSQL(query)
        db.execSQL("INSERT INTO Dane (city, name, description) VALUES ('Gdynia', 'Centrum Nauki Eksperyment', ' centrum nauki, edukacyjna instytucja popularyzująca naukę w formie interaktywnych instalacji i pokazów. Stawia sobie za cel łączenie nauki i zabawy oraz prowadzenie działań upowszechniających naukę.')")
        db.execSQL("INSERT INTO Dane (city, name, description) VALUES ('Gdynia', 'Muzeum Marynarki Wojennej', ' muzeum gromadzące eksponaty związane z Marynarką Wojenną Rzeczypospolitej Polskiej. Powstało w Gdyni 28 czerwca 1953.')")
        db.execSQL("INSERT INTO Dane (city, name, description) VALUES ('Gdansk', 'Muzeum Wojny', 'Muzeum II Wojny Światowej w Gdańsku – państwowa instytucja kultury powołana w 2008. Muzeum zostało otwarte 23 marca 2017. Muzeum jest podległe i nadzorowane przez Ministerstwo Kultury i Dziedzictwa Narodowego.')")
        db.execSQL("INSERT INTO Dane (city, name, description) VALUES ('Gdansk', 'Brama Żuraw', 'zabytkowy dźwig portowy i jedna z bram wodnych Gdańska, która mieści się nad Motławą, na końcu ulicy Szerokiej.')")
        db.execSQL("INSERT INTO Dane (city, name, description) VALUES ('Sopot', 'Molo w Sopocie', 'Molo w Sopocie im. Jana Pawła II – najdłuższe molo nad Morzem Bałtyckim. Ma około pół kilometra długości – część spacerowa ma 511,5 m, z czego 458 m wchodzi w głąb Zatoki Gdańskiej. Jest jedną z największych atrakcji miasta. W głowicy mola jest zlokalizowana przystań morska „Molo” w Sopocie.')")
        db.execSQL("INSERT INTO Dane (city, name, description) VALUES ('Sopot', 'Krzywy Domek', 'Krzywy Domek – został zbudowany w Sopocie przy ul. Bohaterów Monte Cassino 53 według projektu architektów Szotyńskich i Zaleskiego, którego inspiracją były rysunki Jana Marcina Szancera i Pera Dahlberga. Obiekt stanowi część Centrum Handlowego „Rezydent”.')")
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS Dane")
        onCreate(db)
    }

}


class DBHelperGdynia(fragment: FirstFragment): SQLiteOpenHelper(fragment.requireContext(), "db", null, 1) {
    override fun onCreate(db: SQLiteDatabase) {
//        val query = ("CREATE TABLE Dane (id INTEGER PRIMARY KEY AUTOINCREMENT, city TEXT, name TEXT, description TEXT)")
//        db.execSQL(query)
//        db.execSQL("INSERT INTO Dane (city, name, description) VALUES ('Gdynia', 'Centrum Nauki Eksperyment', ' centrum nauki, edukacyjna instytucja popularyzująca naukę w formie interaktywnych instalacji i pokazów. Stawia sobie za cel łączenie nauki i zabawy oraz prowadzenie działań upowszechniających naukę.')")
//        db.execSQL("INSERT INTO Dane (city, name, description) VALUES ('Gdynia', 'Muzeum Marynarki Wojennej', ' muzeum gromadzące eksponaty związane z Marynarką Wojenną Rzeczypospolitej Polskiej. Powstało w Gdyni 28 czerwca 1953.')")
//        db.execSQL("INSERT INTO Dane (city, name, description) VALUES ('Gdansk', 'Muzeum Wojny', 'Muzeum II Wojny Światowej w Gdańsku – państwowa instytucja kultury powołana w 2008. Muzeum zostało otwarte 23 marca 2017. Muzeum jest podległe i nadzorowane przez Ministerstwo Kultury i Dziedzictwa Narodowego.')")
//        db.execSQL("INSERT INTO Dane (city, name, description) VALUES ('Gdansk', 'Brama Żuraw', 'zabytkowy dźwig portowy i jedna z bram wodnych Gdańska, która mieści się nad Motławą, na końcu ulicy Szerokiej.')")
//        db.execSQL("INSERT INTO Dane (city, name, description) VALUES ('Sopot', 'Molo w Sopocie', 'Molo w Sopocie im. Jana Pawła II – najdłuższe molo nad Morzem Bałtyckim. Ma około pół kilometra długości – część spacerowa ma 511,5 m, z czego 458 m wchodzi w głąb Zatoki Gdańskiej. Jest jedną z największych atrakcji miasta. W głowicy mola jest zlokalizowana przystań morska „Molo” w Sopocie.')")
//        db.execSQL("INSERT INTO Dane (city, name, description) VALUES ('Sopot', 'Krzywy Domek', 'Krzywy Domek – został zbudowany w Sopocie przy ul. Bohaterów Monte Cassino 53 według projektu architektów Szotyńskich i Zaleskiego, którego inspiracją były rysunki Jana Marcina Szancera i Pera Dahlberga. Obiekt stanowi część Centrum Handlowego „Rezydent”.')")
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
//        db.execSQL("DROP TABLE IF EXISTS Dane")
//        onCreate(db)
    }

    fun getGdynia(): MutableList<Place> {
        val placelist = mutableListOf<com.example.test3.Place>()
        val db = readableDatabase
        val query = "SELECT id, name, description FROM Dane WHERE city='Gdynia'"
        val cursor = db.rawQuery(query, null)

        while (cursor.moveToNext()) {
            val id = cursor.getInt(cursor.getColumnIndexOrThrow("id"))
            val name = cursor.getString(cursor.getColumnIndexOrThrow("name"))
            val description = cursor.getString(cursor.getColumnIndexOrThrow("description"))

            val place = Place(id, name, description)
            placelist.add(place)
        }
        cursor.close()
        db.close()
        return placelist

    }
}
class DBHelperGdansk(fragment: SecondFragment): SQLiteOpenHelper(fragment.requireContext(), "db", null, 1) {
    override fun onCreate(db: SQLiteDatabase) {
        val query = ("CREATE TABLE Dane (id INTEGER PRIMARY KEY AUTOINCREMENT, city TEXT, name TEXT, description TEXT)")
//        db.execSQL(query)
//        db.execSQL("INSERT INTO Dane (city, name, description) VALUES ('Gdynia', 'Centrum Nauki Eksperyment', ' centrum nauki, edukacyjna instytucja popularyzująca naukę w formie interaktywnych instalacji i pokazów. Stawia sobie za cel łączenie nauki i zabawy oraz prowadzenie działań upowszechniających naukę.')")
//        db.execSQL("INSERT INTO Dane (city, name, description) VALUES ('Gdynia', 'Muzeum Marynarki Wojennej', ' muzeum gromadzące eksponaty związane z Marynarką Wojenną Rzeczypospolitej Polskiej. Powstało w Gdyni 28 czerwca 1953.')")
//        db.execSQL("INSERT INTO Dane (city, name, description) VALUES ('Gdansk', 'Muzeum Wojny', 'Muzeum II Wojny Światowej w Gdańsku – państwowa instytucja kultury powołana w 2008. Muzeum zostało otwarte 23 marca 2017. Muzeum jest podległe i nadzorowane przez Ministerstwo Kultury i Dziedzictwa Narodowego.')")
//        db.execSQL("INSERT INTO Dane (city, name, description) VALUES ('Gdansk', 'Brama Żuraw', 'zabytkowy dźwig portowy i jedna z bram wodnych Gdańska, która mieści się nad Motławą, na końcu ulicy Szerokiej.')")
//        db.execSQL("INSERT INTO Dane (city, name, description) VALUES ('Sopot', 'Molo w Sopocie', 'Molo w Sopocie im. Jana Pawła II – najdłuższe molo nad Morzem Bałtyckim. Ma około pół kilometra długości – część spacerowa ma 511,5 m, z czego 458 m wchodzi w głąb Zatoki Gdańskiej. Jest jedną z największych atrakcji miasta. W głowicy mola jest zlokalizowana przystań morska „Molo” w Sopocie.')")
//        db.execSQL("INSERT INTO Dane (city, name, description) VALUES ('Sopot', 'Krzywy Domek', 'Krzywy Domek – został zbudowany w Sopocie przy ul. Bohaterów Monte Cassino 53 według projektu architektów Szotyńskich i Zaleskiego, którego inspiracją były rysunki Jana Marcina Szancera i Pera Dahlberga. Obiekt stanowi część Centrum Handlowego „Rezydent”.')")
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
//        db.execSQL("DROP TABLE IF EXISTS Dane")
//        onCreate(db)
    }

    fun getGdansk(): MutableList<Place> {
        val placelist = mutableListOf<com.example.test3.Place>()
        val db = readableDatabase
        val query = "SELECT id, name, description FROM Dane WHERE city='Gdansk'"
        val cursor = db.rawQuery(query, null)

        while (cursor.moveToNext()) {
            val id = cursor.getInt(cursor.getColumnIndexOrThrow("id"))
            val name = cursor.getString(cursor.getColumnIndexOrThrow("name"))
            val description = cursor.getString(cursor.getColumnIndexOrThrow("description"))

            val place = Place(id, name, description)
            placelist.add(place)
        }
        cursor.close()
        db.close()
        return placelist
    }
}
class DBHelperSopot(fragment: ThirdFragment) : SQLiteOpenHelper(fragment.requireContext(), "db", null, 1) {
    override fun onCreate(db: SQLiteDatabase) {
        val query = ("CREATE TABLE Dane (id INTEGER PRIMARY KEY AUTOINCREMENT, city TEXT, name TEXT, description TEXT)")
//        db.execSQL(query)
//        db.execSQL("INSERT INTO Dane (city, name, description) VALUES ('Gdynia', 'Centrum Nauki Eksperyment', ' centrum nauki, edukacyjna instytucja popularyzująca naukę w formie interaktywnych instalacji i pokazów. Stawia sobie za cel łączenie nauki i zabawy oraz prowadzenie działań upowszechniających naukę.')")
//        db.execSQL("INSERT INTO Dane (city, name, description) VALUES ('Gdynia', 'Muzeum Marynarki Wojennej', ' muzeum gromadzące eksponaty związane z Marynarką Wojenną Rzeczypospolitej Polskiej. Powstało w Gdyni 28 czerwca 1953.')")
//        db.execSQL("INSERT INTO Dane (city, name, description) VALUES ('Gdansk', 'Muzeum Wojny', 'Muzeum II Wojny Światowej w Gdańsku – państwowa instytucja kultury powołana w 2008. Muzeum zostało otwarte 23 marca 2017. Muzeum jest podległe i nadzorowane przez Ministerstwo Kultury i Dziedzictwa Narodowego.')")
//        db.execSQL("INSERT INTO Dane (city, name, description) VALUES ('Gdansk', 'Brama Żuraw', 'zabytkowy dźwig portowy i jedna z bram wodnych Gdańska, która mieści się nad Motławą, na końcu ulicy Szerokiej.')")
//        db.execSQL("INSERT INTO Dane (city, name, description) VALUES ('Sopot', 'Molo w Sopocie', 'Molo w Sopocie im. Jana Pawła II – najdłuższe molo nad Morzem Bałtyckim. Ma około pół kilometra długości – część spacerowa ma 511,5 m, z czego 458 m wchodzi w głąb Zatoki Gdańskiej. Jest jedną z największych atrakcji miasta. W głowicy mola jest zlokalizowana przystań morska „Molo” w Sopocie.')")
//        db.execSQL("INSERT INTO Dane (city, name, description) VALUES ('Sopot', 'Krzywy Domek', 'Krzywy Domek – został zbudowany w Sopocie przy ul. Bohaterów Monte Cassino 53 według projektu architektów Szotyńskich i Zaleskiego, którego inspiracją były rysunki Jana Marcina Szancera i Pera Dahlberga. Obiekt stanowi część Centrum Handlowego „Rezydent”.')")
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
//        db.execSQL("DROP TABLE IF EXISTS Dane")
//        onCreate(db)
    }

    fun getSopot(): MutableList<Place> {
        val placelist = mutableListOf<Place>()
        val db = readableDatabase
        val query = "SELECT id, name, description FROM Dane WHERE city='Sopot'"
        val cursor = db.rawQuery(query, null)

        while (cursor.moveToNext()) {
            val id = cursor.getInt(cursor.getColumnIndexOrThrow("id"))
            val name = cursor.getString(cursor.getColumnIndexOrThrow("name"))
            val description = cursor.getString(cursor.getColumnIndexOrThrow("description"))

            val place = Place(id, name, description)
            placelist.add(place)
        }
        cursor.close()
        db.close()
        return placelist
    }
}


