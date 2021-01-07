package com.devtech.mditest.data


import androidx.room.*
import com.devtech.mditest.data.entity.*
import kotlinx.coroutines.flow.Flow

@Dao
interface TestDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCategory(category: Category)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPoduct(product: Product)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProductCategoryCrossRef(productCategoryCrossRef: ProductCategoryCrossRef)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavorite(favorite: Favorite)

    @Query("SELECT * FROM category_table")
    fun getCategory(): Flow<List<Category>>

    @Transaction
    @Query("SELECT * FROM product_table")
    fun getProductWithCategory(): List<ProductWithCategory>

    @Transaction
    @Query("SELECT * FROM category_table WHERE categoryId = :category")
    fun getCategoryWithProduct(category: Int): List<CategoryWithProduct>

    @Transaction
    @Query("SELECT * FROM product_table")
    fun getProductAndFavorite(): List<ProductAndFavorite>
}