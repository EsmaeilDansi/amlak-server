package com.example.amalk;

import com.example.amalk.models.User;
import com.example.amalk.repo.UserRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.List;

@Configuration
class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);


    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Bean
    CommandLineRunner initDatabase(UserRepo repository) {
        log.info("init database\n");
//        String sel = "UPSERT INTO users VALUES('terfdtweqw88u','esi','eeewe',45435,435345)";
//        int rows = jdbcTemplate.update(sel);
//        if (rows > 0) {
//            System.out.println("A new row has been inserted.");
//        }




//        for (User user:result){
//            System.out.print(user.toString()+"\n");
//        }
        //System.out.print("5555555555555555555555" + user.toString());
//        jdbcTemplate.update(sel1, preparedStatement -> {
//            preparedStatement.setString(1,"333333333333");
//            preparedStatement.setString(2,"esmaeileeeeeeeeeeeeeeeeeeeeeeeeei");
//            preparedStatement.setString(3,"dansi");
//            preparedStatement.setInt(4,645);
//            preparedStatement.setInt(5,64543434);
//        });

     //   repository.save(new User("434rer","rer","rer",444,4324));

//            statement.execute("CREATE TABLE COMPANY(\n" +
//                    "   ID INT PRIMARY KEY     NOT NULL,\n" +
//                    "   NAME           TEXT    NOT NULL,\n" +
//                    "   AGE            INT     NOT NULL,\n" +
//                    "   ADDRESS        CHAR(50),\n" +
//                    "   SALARY         REAL\n" +
//                    ");");
//            ResultSet resultSet = statement.executeQuery("SELECT * FROM users");
//            List<User> res =  repository.findAll();
//
//            for(User user:res){
//                System.out.print(user.toString());
//            }
//
//            while (resultSet.next()) {
//                int id = resultSet.getInt("id");
//                String name = resultSet.getString("name");
//                String last_name = resultSet.getString("last_name");
//                System.out.print(id + "\t " + name + "\t" + last_name + "\n");
//            }

       // List<User> res = repository.findAll();

//        for(User user:res){
//            System.out.print("name"+user.getName()+"\n");
//        }


        return args -> {

        };
    }
}
