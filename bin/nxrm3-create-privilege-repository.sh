#!/bin/bash

playbook=nxrm3-create-privilege-repository

ansible-playbook -v ../playbooks/${playbook}.yml --extra-vars @data/privilege-repository.json



