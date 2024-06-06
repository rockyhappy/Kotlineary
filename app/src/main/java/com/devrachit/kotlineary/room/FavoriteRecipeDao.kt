package com.devrachit.kotlineary.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface FavoriteRecipeDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavorite(recipe: FavoriteRecipe)

    @Query("DELETE FROM favorite_recipes WHERE id = :recipeId")
    suspend fun deleteFavorite(recipeId: Int)

    @Query("SELECT * FROM favorite_recipes WHERE id = :recipeId")
    suspend fun getFavorite(recipeId: Int): FavoriteRecipe?

    @Query("SELECT * FROM favorite_recipes")
    suspend fun getAllFavorites(): List<FavoriteRecipe>
}
