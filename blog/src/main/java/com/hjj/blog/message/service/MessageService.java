package com.hjj.blog.message.service;

import com.hjj.blog.message.dao.MessageDao;
import com.hjj.blog.projo.CriteriaMessage;
import com.hjj.blog.projo.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author haojunjie
 * @create 2019-03-28 20:23
 */
@Service
@Transactional
public class MessageService {
    @Autowired
    private MessageDao messageDao;

    public List<CriteriaMessage> getCriteriaMessagesByUserId(int userId) {
        return messageDao.getCriteriaMessagesByUserId(userId);
    }

    //点击过的信息更新下is_read为true
    public boolean updateCriteriaMessagesById(int id) {
        return messageDao.updateCriteriaMessagesById(id);
    }
}
