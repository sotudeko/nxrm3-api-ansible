#!/bin/bash

playbook=nxrm3-create-content-selector

ansible-playbook -v ../playbooks/${playbook}.yml --extra-vars @data/content-selector.json



