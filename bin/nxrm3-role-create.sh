#!/bin/bash

playbook=nxrm3-role-create

ansible-playbook -vv ../playbooks/${playbook}.yml --extra-vars @data/role.json



