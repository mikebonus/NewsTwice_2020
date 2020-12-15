package com.manhee.newsapp_2020_mk.ui

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

/** 'Database class' is one of the 3 (usually) main entities to...
 * exist (along with 'DAO' and 'Entity' (and 'Converters' in this case)) **/

@Database(entities = [Article::class], version = 1)
@TypeConverters(Converters::class)
abstract class ArticleDatabase : RoomDatabase() {

    abstract fun getArticleDao(): ArticleDao

    // Companion object to call the fields and methods inside this object
    // from anywhere without having to create an instance of this class...
    companion object {

        // 'Volatile' to allow only one thread at a time...
        @Volatile
        private var instance: ArticleDatabase? = null
        private val LOCK = Any()
        // to synchronize setting the 'instance'
        // (ie. there should ALWAYS be one instance of the D/B at a time)

        // method #1:
        // called whenever we are creating a DB instance
        // (ie. init / instantiate this object)
        // cannot be accessed by other thread to set the instance (ie. only one at a time)!!
        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: createDatabase(context).also { instance = it }

            // if null, then we can call 'method #2' below
        }

        // method #2:
        // instantiates the DATABASE! (under the condition as set above under invoke())
        private fun createDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                ArticleDatabase::class.java,
                "article_db.db"
            ).build()

    }
}