package com.quruiqi.myadmin.system.service.query;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.quruiqi.myadmin.common.utils.PageUtil;
import com.quruiqi.myadmin.common.utils.SqlUtil;
import com.quruiqi.myadmin.system.domain.QUser;
import com.quruiqi.myadmin.system.domain.User;
import com.quruiqi.myadmin.system.repository.UserRepository;
import com.quruiqi.myadmin.system.service.dto.UserDTO;
import com.quruiqi.myadmin.system.service.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author Lenovo
 * @Date 2023/9/28 11:06
 **/
@Service
@CacheConfig(cacheNames = "user")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
@RequiredArgsConstructor
public class UserQueryService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    /**
     * 分页
     * @param userDTO
     * @param pageable
     * @return
     */
    public Object queryAll(UserDTO userDTO, Pageable pageable) {
        Page<UserDTO> page = userRepository.findAll(new Spec(userDTO), pageable).map(userMapper::toDto);
        return PageUtil.toPage(page);
    }

    /**
     * 不分页
     * @param userDTO
     * @return
     */
    public Object queryAll(UserDTO userDTO) {
        return userMapper.toDto(userRepository.findAll(new Spec(userDTO)));
    }

    class Spec implements Specification<User>{

        private UserDTO userDTO;

        public Spec(UserDTO userDTO) {
            this.userDTO = userDTO;
        }

        @Override
        public Predicate toPredicate(Root<User> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

            List<Predicate> list = new ArrayList<>();

            if (ObjectUtils.isEmpty(userDTO.getId())) {
                list.add(criteriaBuilder.equal(root.get("id").as(Long.class), userDTO.getId()));
            }
            if (ObjectUtils.isEmpty(userDTO.getEnabled())) {
                list.add(criteriaBuilder.equal(root.get("enabled").as(Boolean.class), userDTO.getEnabled()));
            }
            if (ObjectUtils.isEmpty(userDTO.getUsername())) {
                list.add(criteriaBuilder.like(root.get("username").as(String.class), SqlUtil.like(userDTO.getUsername())));
            }
            if (ObjectUtils.isEmpty(userDTO.getEmail())) {
                list.add(criteriaBuilder.like(root.get("email").as(String.class), SqlUtil.like(userDTO.getEmail())));
            }

            return criteriaBuilder.and(list.toArray(new Predicate[list.size()]));
        }
    }

}
