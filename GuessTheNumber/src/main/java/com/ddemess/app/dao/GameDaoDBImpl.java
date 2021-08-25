/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ddemess.app.dao;

import com.ddemess.app.model.Game;
import com.ddemess.app.model.Round;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Dagmawi Demess
 */
@Repository
public class GameDaoDBImpl implements GameDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public GameDaoDBImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional
    public void deleteGameById(int gameId) {
        final String DELETE_GAME = "DELETE FROM game WHERE id = ?";
        final String DELETE_Round = "DELETE FROM round WHERE id = ?";
        jdbcTemplate.update(DELETE_Round, gameId);
        jdbcTemplate.update(DELETE_GAME, gameId);
    }

    @Override
    @Transactional
    public void deleteRoundById(int roundId) {

        final String DELETE_ROUND = "DELETE FROM round WHERE id = ?";
        jdbcTemplate.update(DELETE_ROUND, roundId);
    }

    @Override
    public Game getGameById(int id) {
        final String sql = "SELECT id, answer,status FROM game WHERE id = ?;";
        return jdbcTemplate.queryForObject(sql, new GameMapper(), id);

    }

    @Override
    public Game add(Game game) {
        final String sql = "INSERT INTO game(answer,status) VALUES(?,?);";
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update((Connection conn) -> {

            PreparedStatement statement = conn.prepareStatement(
                    sql,
                    Statement.RETURN_GENERATED_KEYS);

            statement.setString(1, game.getAnswer());
            statement.setString(2, game.getStatus());
            return statement;

        }, keyHolder);
        game.setId(keyHolder.getKey().intValue());

        return game;
    }

    @Override
    public List<Game> getAllGames() {
        final String sql = "SELECT id, answer, status from game;";
        return jdbcTemplate.query(sql, new GameMapper());
    }

    @Override
    public Round saveRound(Round rounds, int gameId) {
        final String sql = "INSERT INTO round(guess, result,id, guessTime) VALUES(?,?,?,?);";
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
                PreparedStatement statement = conn.prepareStatement(
                        sql,
                        Statement.RETURN_GENERATED_KEYS);
                statement.setString(1, rounds.getGuess());
                statement.setString(2, rounds.getResult());
                statement.setInt(3, gameId);
                statement.setString(4, rounds.getGuessTime());
                return statement;
            }
        }, keyHolder);
        rounds.setGameId(gameId);
        rounds.setRoundId(keyHolder.getKey().intValue());

        return rounds;
    }

    @Override
    public void updateGameFinished(int gameId) {
        final String sql = "UPDATE game SET  status= ? where id= ?";
        jdbcTemplate.update(sql, "Finished", gameId);

    }

    @Override
    public Round getRoundById(int roundId) {
        final String sql = "SELECT roundId, guess,result,guessTime,id FROM round WHERE roundId = ?;";
        return jdbcTemplate.queryForObject(sql, new RoundMapper(), roundId);
    }

    @Override
    public List<Round> getAllRounds() {
        final String sql = "SELECT roundId, guess, result,guessTime,id from round;";
        return jdbcTemplate.query(sql, new RoundMapper());
    }

    @Override
    public List<Round> getRounds(int gameId) {
        final String sql = "SELECT roundId, guess,result,guessTime,id from round where id = ? ";
        return jdbcTemplate.query(sql, new RoundMapper(), gameId);

    }

    private static final class RoundMapper implements RowMapper<Round> {

        @Override
        public Round mapRow(ResultSet rs, int index) throws SQLException {
            Round rounds = new Round();
            rounds.setRoundId(rs.getInt("roundId"));
            rounds.setGuessTime(rs.getString("guessTime"));
            rounds.setGuess(rs.getString("guess"));
            rounds.setResult(rs.getString("result"));
            rounds.setGameId(rs.getInt("id"));
            return rounds;
        }
    }

    private static final class GameMapper implements RowMapper<Game> {

        @Override
        public Game mapRow(ResultSet rs, int index) throws SQLException {
            Game game = new Game();
            game.setId(rs.getInt("id"));
            game.setAnswer(rs.getString("answer"));
            game.setStatus(rs.getString("status"));
            return game;
        }

    }

}
