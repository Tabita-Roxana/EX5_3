package com.example.demo.user;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class DAO
{
  private final UserRepository repository;

  public DAO(UserRepository repository)
  {
    this.repository = repository;
  }

  @GetMapping("/users")
  List<User> all() {
    return repository.findAll();
  }

  @PostMapping("/users")
  User newEmployee(@RequestBody User newUser) {
    return repository.save(newUser);
  }

  @GetMapping("/users/{id}")
  User one(@PathVariable Integer id) {

    return repository.findById(id)
            .orElseThrow(() -> new UserNotFoundException(id));
  }
  @PutMapping("/users/{id}")
  User replaceUser(@RequestBody User newUser, @PathVariable Integer id) {

    return repository.findById(id)
            .map(user -> {
              user.setEmail(newUser.getEmail());
              user.setPassword(newUser.getPassword());
              return repository.save(user);
            })
            .orElseGet(() -> {
              newUser.setId(id);
              return repository.save(newUser);
            });
  }
  @DeleteMapping("/users/{id}")
  void deleteUser(@PathVariable Integer id) {
    repository.deleteById(id);
  }
}
