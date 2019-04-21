#!/bin/bash

playbook=nxrm3-role-create

ansible-playbook -v ../playbooks/${playbook}.yml --extra-vars @data/role.json



