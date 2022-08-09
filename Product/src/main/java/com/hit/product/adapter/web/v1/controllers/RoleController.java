package com.hit.product.adapter.web.v1.controllers;

import com.hit.product.adapter.web.base.RestApiV1;
import com.hit.product.adapter.web.base.VsResponseUtil;
import com.hit.product.applications.constants.UrlConstant;
import com.hit.product.applications.services.RoleService;
import com.hit.product.domains.dtos.RoleDto;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestApiV1
public class RoleController {

    @Autowired
    RoleService roleService;

    @ApiOperation(value = "Get All Role")
    @GetMapping(UrlConstant.Role.DATA_ROLE)
    public ResponseEntity<?> getAllRole() {
        return VsResponseUtil.ok(roleService.getAllRole());
    }

    @ApiOperation(value = "Get Role By Id")
    @GetMapping(UrlConstant.Role.DATA_ROLE_ID)
    public ResponseEntity<?> getRoleById(@PathVariable("id") Long id) {
        return VsResponseUtil.ok(roleService.findRoleById(id));
    }

    @ApiOperation(value = "Create Role")
    @PostMapping(UrlConstant.Role.DATA_ROLE_CREATE)
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<?> createRole(@RequestBody RoleDto roleDto) {
        return VsResponseUtil.ok(roleService.createRole(roleDto));
    }

    @ApiOperation(value = "Delete Role")
    @DeleteMapping(UrlConstant.Role.DATA_ROLE_ID)
    public ResponseEntity<?> deleteRole(@PathVariable("id") Long id) {
        return VsResponseUtil.ok(roleService.deleteRoleById(id));
    }
}
