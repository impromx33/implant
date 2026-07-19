package com.c2.implant
import android.accessibilityservice.AccessibilityService
import android.view.accessibility.AccessibilityEvent
class C2AccessibilityService : AccessibilityService() {
    override fun onAccessibilityEvent(event: AccessibilityEvent) {}
    override fun onInterrupt() {}
}
