package prj.springcrud.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import prj.springcrud.db.DatabaseConnection;
import java.util.*;

@Repository
public class UserRepository {
    private DatabaseConnection db;

    @Autowired
    public UserRepository(DatabaseConnection db) {
        this.db = db;
    }

    public List<String> findAll(){
        return db.getUsers();
    }

    public void save(String user){
        db.addUser(user);
    }
}
