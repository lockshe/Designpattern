package ynu.service;

import ynu.entity.User;

import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


public interface IUserService {

	/**
     * 更新用户权限
     *
     * @param id 用户编号
     * @param permission 权限
     *
     * @return 是否更新成功
     */
    boolean updatePermission(int id, int permission);

    /**
     * 重置用户密码
     *
     * @param id 用户编号
     * @param password 密码
     *
     * @return 是否重置成功
     */
    boolean resetPassword(int id, String password);

    /**
     * 更新用户权限
     *
     * @param id 编号
     * @param auths 操作文件的权限集
     *
     * @return 是否更新成功
     */
    boolean updateFileAuth(int id, String auths);

    /**
     * 获取用户
     *
     * @param permission 当前用户权限
     * @param condition 筛选条件
     *
     * @return {@link List}
     */
    List<User> listUser(int permission, String condition);

    /**
     * 登录
     *
     * @param loginName 登录名
     * @param password 密码
     * @param token 自动登录
     * @param response 响应
     *
     * @return {@link User}
     */
    User login(String loginName, String password, HttpServletResponse response);

    /**
     * 注册
     *
     * @param username 用户名
     * @param email 邮箱
     * @param password 密码
     *
     * @return 是否插入成功
     */
    boolean register(String username, String email, String password);

    /**
     * 重置密码
     *
     * @param email 邮箱
     * @param password 密码
     *
     * @return {@link Boolean}
     */
    boolean resetPasswordByEmail(String email, String password);


    /**
     * 检查用户名是否存在
     *
     * @param username 用户名
     *
     * @return {@link Boolean}
     */
    boolean usernameExists(String username);

    /**
     * 通过编号获取用户
     *
     * @param id 编号
     *
     * @return {@link User}
     */
    User getUserById(int id);

    /**
     * 更新用户登录时间
     *
     * @param user {@link User}
     */
    void updateUserLoginTime(User user);

    /**
     * 更新密码
     *
     * @param password 密码
     * @param id 用户编号
     *
     * @return 是否更新成功
     */
    boolean updatePasswordById(int id,String password);

    /**
     * 检查密码是否合法
     *
     * @param password 密码
     *
     * @return {@link Boolean}
     */
    boolean checkPassword(String password);

    /**
     * 检查邮箱是否存在
     *
     * @param email 邮箱
     *
     * @return {@link Boolean}
     */
    boolean emailExists(String email);

    /**
     * 更新用户基本信息
     *
     * @param id 编号
     * @param avatar 头像
     * @param realName 真实姓名
     * @param email 邮箱
     *
     * @return 是否更新成功
     */
    boolean updateBasicInfoById(int id, String realName, String email);

    /**
     * 通过用户名获取用户Id
     *
     * @param usernameOrEmail 用户名或邮箱
     *
     * @return 用户编号
     */
    int getUserId(String usernameOrEmail);
    
    
    //根据用户名称获取头像路径
    String getAvatarByUsername(String usernameOrEmail);
    
	//根据ID设置用户头像路径
	boolean uploadAvatar(int id,MultipartFile multipartFile) throws IllegalStateException, IOException;
	

}
