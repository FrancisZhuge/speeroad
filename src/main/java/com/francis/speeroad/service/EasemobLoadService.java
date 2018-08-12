package com.francis.speeroad.service;

import java.io.File;

import com.francis.speeroad.entity.upload.LoadResponse;

/**
 * @author hzzhugequn
 * @date 2018/8/12
 * @since JDK 1.8
 */
public interface EasemobLoadService {

    LoadResponse upload(File file);

}
