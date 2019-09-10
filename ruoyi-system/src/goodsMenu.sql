-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('商品(goods)', '3', '1', '/goods/goods', 'C', '0', 'goods:goods:view', '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '商品(goods)菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('商品(goods)查询', @parentId, '1',  '#',  'F', '0', 'goods:goods:list',         '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('商品(goods)新增', @parentId, '2',  '#',  'F', '0', 'goods:goods:add',          '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('商品(goods)修改', @parentId, '3',  '#',  'F', '0', 'goods:goods:edit',         '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('商品(goods)删除', @parentId, '4',  '#',  'F', '0', 'goods:goods:remove',       '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');
