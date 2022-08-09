package com.hit.product.adapter.web.v1.controllers;

import com.hit.product.adapter.web.base.RestApiV1;
import com.hit.product.adapter.web.base.VsResponseUtil;
import com.hit.product.applications.constants.UrlConstant;
import com.hit.product.applications.services.NotificationService;
import com.hit.product.domains.dtos.NotificationDto;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestApiV1
public class NotificationController {

    @Autowired
    NotificationService notificationService;

    @GetMapping(UrlConstant.Notification.DATA_NOTIFICATION)
    @ApiOperation(value = "Get All Notifications In Database")
    public ResponseEntity<?> getNotifications() {
        return VsResponseUtil.ok(notificationService.getNotifications());
    }

    @GetMapping(UrlConstant.Notification.DATA_NOTIFICATION_ID)
    @ApiOperation(value = "Get Notification By Id Notification")
    public ResponseEntity<?> getNotificationById(@PathVariable("id") Long id) {
        return VsResponseUtil.ok(notificationService.getNotificationById(id));
    }

    @PostMapping(UrlConstant.Notification.DATA_NOTIFICATION_CREATE)
    @ApiOperation(value = "Create Notification")
    public ResponseEntity<?> createNotification(@RequestBody NotificationDto NotificationDto) {
        return VsResponseUtil.ok(notificationService.createNotification(NotificationDto));
    }

    @PostMapping(UrlConstant.Notification.DATA_NOTIFICATION_FOR_USER)
    @ApiOperation(value = "Create Notification For User")
    public ResponseEntity<?> createNotificationForUser(@PathVariable("idUser") Long idUser, @RequestBody NotificationDto notificationDto) {
        return VsResponseUtil.ok(notificationService.createNotificationForUser(idUser, notificationDto));
    }

    @PatchMapping(UrlConstant.Notification.DATA_NOTIFICATION_ID)
    @ApiOperation(value = "Update Notification By Id Notification")
    public ResponseEntity<?> updateNotification(@PathVariable("id") Long id, @RequestBody NotificationDto notificationDto) {
        return VsResponseUtil.ok(notificationService.updateNotification(id, notificationDto));
    }

    @DeleteMapping(UrlConstant.Notification.DATA_NOTIFICATION_ID)
    @ApiOperation(value = "Delete Notification By Id Notification")
    public ResponseEntity<?> deleteNotification(@PathVariable("id") Long id) {
        return VsResponseUtil.ok(notificationService.deleteNotification(id));
    }
}
