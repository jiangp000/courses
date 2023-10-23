<template>
  <div>
    <el-menu
        default-active="1"
        class="el-menu-vertical-demo"
        background-color="#545c64"
        text-color="#fff"
        active-text-color="#ffd04b">

      <el-submenu index="1">
        <template slot="title">
          <i class="el-icon-location"></i>
          <span>选项 1</span>
        </template>
        <el-menu-item-group>
          <el-menu-item index="1-1">子项一</el-menu-item>
          <el-menu-item index="1-2">子项二</el-menu-item>
        </el-menu-item-group>
      </el-submenu>

      <el-menu-item index="2">
        <i class="el-icon-menu"></i>
        <span slot="title">选项 2</span>
      </el-menu-item>

    </el-menu>
  </div>
</template>

<script>
export default {
  name: 'SidebarMenu'
}
</script>

<style>
/* 在这里设计你的侧边栏菜单样式 */
</style>
