import request from '@/utils/request'

// 查询账户管理列表
export function listUser(query) {
  return request({
    url: '/admin/user/list',
    method: 'get',
    params: query
  })
}

// 查询账户管理详细
export function getUser(id) {
  return request({
    url: '/admin/user/' + id,
    method: 'get'
  })
}

// 新增账户管理
export function addUser(data) {
  return request({
    url: '/admin/user',
    method: 'post',
    data: data
  })
}

// 修改账户管理
export function updateUser(data) {
  return request({
    url: '/admin/user',
    method: 'put',
    data: data
  })
}

// 删除账户管理
export function delUser(id) {
  return request({
    url: '/admin/user/' + id,
    method: 'delete'
  })
}