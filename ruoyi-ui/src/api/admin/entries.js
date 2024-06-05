import request from '@/utils/request'

// 查询作品管理列表
export function listEntries(query) {
  return request({
    url: '/admin/entries/list',
    method: 'get',
    params: query
  })
}

// 查询作品管理详细
export function getEntries(entriesId) {
  return request({
    url: '/admin/entries/' + entriesId,
    method: 'get'
  })
}

// 新增作品管理
export function addEntries(data) {
  return request({
    url: '/admin/entries',
    method: 'post',
    data: data
  })
}

// 修改作品管理
export function updateEntries(data) {
  return request({
    url: '/admin/entries',
    method: 'put',
    data: data
  })
}

// 删除作品管理
export function delEntries(entriesId) {
  return request({
    url: '/admin/entries/' + entriesId,
    method: 'delete'
  })
}
