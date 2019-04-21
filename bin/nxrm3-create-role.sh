#!/bin/bash

playbook=nxrm3-create-role

ansible-playbook -v ../playbooks/${playbook}.yml --extra-vars @data/role.json



