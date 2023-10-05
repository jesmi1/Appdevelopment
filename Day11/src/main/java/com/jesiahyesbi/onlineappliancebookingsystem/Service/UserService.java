
package com.jesiahyesbi.onlineappliancebookingsystem.Service;
import java.util.List;

import com.jesiahyesbi.onlineappliancebookingsystem.Dto.request.UserRequest;
import com.jesiahyesbi.onlineappliancebookingsystem.Dto.response.UserResponse;


public interface UserService {

    List<UserResponse> getAllUsers();

    UserResponse getUser(Long uid);

    UserResponse updateUser(UserRequest request, Long uid);

    boolean deleteProduct(Long uid);

}
