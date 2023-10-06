package com.onlineappliancebookingsystem.Service.impl;

import com.onlineappliancebookingsystem.Dto.request.AuthenticationRequest;
import com.onlineappliancebookingsystem.Dto.request.RegisterRequest;
import com.onlineappliancebookingsystem.Dto.response.AuthenticationResponse;

public interface AuthService {
    boolean userRegistration(RegisterRequest request);

    AuthenticationResponse userAuthentication(AuthenticationRequest request);
}
