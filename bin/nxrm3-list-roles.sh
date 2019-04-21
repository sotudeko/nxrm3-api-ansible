#!/bin/bash

playbook=nxrm3-list-roles

script_name=list_roles

ansible-playbook ../playbooks/${playbook}.yml --extra-vars "script_name=${script_name}"

