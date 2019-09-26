package com.ank.cms.service;

import com.ank.cms.model.Log;

public interface logService {
    Log selById();

    void add();

    void remove();

    void modify();
}
