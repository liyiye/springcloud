#!/bin/bash
mkidr -p /app/log
nohup java com.framework.core.inter.FrameworkApplication  $1 >/app/log/$2.log