package testtask.footballmanager.service;

import testtask.footballmanager.dto.request.TransferRequestDto;

public interface TransferService {
    String transfer(TransferRequestDto dto);
}
