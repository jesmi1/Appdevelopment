package com.jesiahyesbi.onlineappliancebookingsystem.Service.impl;

import com.jesiahyesbi.onlineappliancebookingsystem.Dto.request.AuthenticationRequest;
import com.jesiahyesbi.onlineappliancebookingsystem.Dto.request.RegisterRequest;
import com.jesiahyesbi.onlineappliancebookingsystem.Dto.response.AuthenticationResponse;

public interface AuthService {
    boolean userRegistration(RegisterRequest request);

    AuthenticationResponse userAuthentication(AuthenticationRequest request);
}
