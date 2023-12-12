package com


import androidx.room.Dao
import androidx.room.Database
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.PrimaryKey
import androidx.room.Query
import androidx.room.RoomDatabase
import androidx.room.Update

// Dealer Entity representing dealer information
@Entity(tableName = "dealer")
data class Dealer(
 @PrimaryKey val dealerId: Int,
 val dealerName: String,
 val dealerStatus: String
 // Other dealer-related fields as needed
)

// Player Entity representing player details
@Entity(tableName = "players")
data class Player(
 @PrimaryKey val playerId: Int,
 val playerName: String,
 var score: Int
 // Other player-related fields as needed
)

// Game Round Entity representing game rounds
@Entity(tableName = "game_rounds")
data class GameRound(
 @PrimaryKey val roundId: Int,
 val playersInvolved: List<Int>, // List of player IDs involved in this round
 // Other round-related fields as needed
)
@Dao
interface Worker{

 // Player operations
 @Insert
 fun insertPlayer(player: Player)

 @Query("SELECT * FROM players WHERE playerId = :playerId")
 fun getPlayer(playerId: Int): Player

 @Query("SELECT * FROM players WHERE playerName = :playerName")
 fun getPlayerByName(playerName: String): Player

 @Update
 fun updatePlayer(player: Player)

 // Game round operations
 @Insert
 fun insertGameRound(gameRound: GameRound)

 @Query("SELECT * FROM game_rounds WHERE roundId = :roundId")
 fun getGameRound(roundId: Int): GameRound

 // Dealer operations
 @Insert
 fun insertDealer(dealer: Dealer)

 @Query("SELECT * FROM dealer WHERE dealerId = :dealerId")
 fun getDealer(dealerId: Int): Dealer


}




}

 abstract class DataBase: RoomDatabase() {


  abstract fun yDao(): YDao
}