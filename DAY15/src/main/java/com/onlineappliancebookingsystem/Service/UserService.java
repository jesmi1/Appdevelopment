
package com.onlineappliancebookingsystem.Service;
import java.util.List;

import com.onlineappliancebookingsystem.Dto.request.UserRequest;
import com.onlineappliancebookingsystem.Dto.response.UserResponse;


public interface UserService {

    List<UserResponse> getAllUsers();

    UserResponse getUser(Long uid);

    UserResponse updateUser(UserRequest request, Long uid);

    boolean deleteProduct(Long uid);

}
