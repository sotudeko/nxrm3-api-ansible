#!/bin/bash

playbook=nxrm3-list-privileges

script_name=list_privileges

ansible-playbook ../playbooks/${playbook}.yml --extra-vars "script_name=${script_name}"

